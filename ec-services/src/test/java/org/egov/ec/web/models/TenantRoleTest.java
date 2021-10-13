package org.egov.ec.web.models;

import java.util.List;
import org.egov.common.contract.request.Role;
import org.egov.ec.web.models.TenantRole;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TenantRoleTest</code> contains tests for the class <code>{@link TenantRole}</code>.
 *
 * @generated at 17/5/20 2:11 PM
 * @version $Revision: 1.0 $
 */
public class TenantRoleTest {
	/**
	 * Run the TenantRole() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testTenantRole_1()
		throws Exception {

		TenantRole result = new TenantRole();

		
		assertNotNull(result);
		assertEquals(null, result.getTenantId());
	}

	/**
	 * Run the TenantRole(String,List<Role>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testTenantRole_2()
		throws Exception {
		String tenantId = "";
		List<Role> roles = null;
	
		TenantRole result = new TenantRole(tenantId, roles);		
		
		assertNotNull(result);
		assertEquals("", result.getTenantId());
	}

	/**
	 * Run the TenantRole addRolesItem(Role) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testAddRolesItem_1()
		throws Exception {
		TenantRole fixture = new TenantRole("", null);
	}

	/**
	 * Run the TenantRole.TenantRoleBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		TenantRole.TenantRoleBuilder result = TenantRole.builder();

		
		assertNotNull(result);
		assertEquals("TenantRole.TenantRoleBuilder(tenantId=null, roles=null)", result.toString());
	}

	@Test
	public void testBuilder_2()
		throws Exception {

		TenantRole.TenantRoleBuilder builder = TenantRole.builder();
		builder.tenantId(null);
		builder.roles(null);
		builder.build();
		
		TenantRole.TenantRoleBuilder builder2 = TenantRole.builder();
		builder2.tenantId(null);
		builder2.roles(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	/**
	 * Run the List<Role> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetRoles_1()
		throws Exception {
		TenantRole fixture = new TenantRole("", null);

		List<Role> result = fixture.getRoles();	
		assertEquals(null, result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		TenantRole fixture = new TenantRole("", null);

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}

	/**
	 * Run the void setRoles(List<Role>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetRoles_1()
		throws Exception {
		TenantRole fixture = new TenantRole("", null);
		List<Role> roles = null;
		// add mock object expectations here

		

		fixture.setRoles(roles);

		
		
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		TenantRole fixture = new TenantRole("", null);
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}
}