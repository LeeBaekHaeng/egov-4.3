/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package egovframework.example.bat.domain.trade;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 배치실행개발팀
 * @since 2012. 07.25
 * @version 1.0
 * @see
 *  <pre>
 *      개정이력(Modification Information)
 *
 *   수정일      수정자           수정내용
 *  ------- -------- ---------------------------
 *  2012. 07.25  배치실행개발팀     최초 생성
 *  </pre>
 */

public class CustomerCreditRowMapper implements RowMapper<CustomerCredit> {

	// "id"를 나타내는 상수
	public static final String ID_COLUMN = "id";

	// "name"를 나타내는 상수
	public static final String NAME_COLUMN = "name";

	// "credit"를 나타내는 상수
	public static final String CREDIT_COLUMN = "credit";

	/**
	 * CustomerCredit VO를 set
	 */
	@Override
	public CustomerCredit mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerCredit customerCredit = new CustomerCredit();

		customerCredit.setId(rs.getInt(ID_COLUMN));
		customerCredit.setName(rs.getString(NAME_COLUMN));
		customerCredit.setCredit(rs.getBigDecimal(CREDIT_COLUMN));

		return customerCredit;
	}

}
