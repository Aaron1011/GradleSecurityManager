package pw.aaron1011.gradlesecuritymanager;

import org.junit.Test;

import java.security.Permission;

public class SecurityManagerBug {

    @Test
    public void testSecurityManagerCleanExit() {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                if (perm.getName() == null) {
                    return;
                }
                if (perm.getName().equals("setSecurityManager")) {
                    throw new SecurityException("You cannot replace this security manager!");
                }
            }
        });
    }

}
