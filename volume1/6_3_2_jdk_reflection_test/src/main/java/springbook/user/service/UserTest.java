package springbook.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: 노상현
 * Date: 2019-01-28
 */

public class UserTest {
    User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test()
    public void upgradeLevel() {
        Level[] levels = Level.values();

        for (Level level : levels) {
            if (level.nextLevel() == null)
                continue;
            user.setLevel(level);
            user.upgradeLevel();
            assertThat(user.getLevel(), is(level.nextLevel()));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void cannotUpgradeLevel() {
        Level[] levels = Level.values();

        for (Level level : levels) {
            if (level.nextLevel() != null)
                continue;
            user.setLevel(level);
            user.upgradeLevel();
        }
    }

    public static void main(String[] args) {
        JUnitCore.main("springbook.user.service.UserTest");
    }
}
