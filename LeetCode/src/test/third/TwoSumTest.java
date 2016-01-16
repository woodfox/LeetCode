package third;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    @Test
    public void verify() {
        TwoSum instance = new TwoSum();

        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2, 8, 9, 3}, 10), new int[]{2, 3});
        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2, 8, 9, 3}, 12), new int[]{1, 2});
        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2, 8, 9, 3}, 11), new int[]{2, 4});
        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2, 8, 9, 3}, 5), new int[]{2, 5});
        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2, 8, 9, 3}, 19), new int[]{1, 4});
        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2, 8, 9, 3}, 17), new int[]{3, 4});
        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2}, 12), new int[]{1, 2});
        Assert.assertArrayEquals(instance.twoSum(new int[]{10, 2, 3}, 13), new int[]{1, 3});
        Assert.assertArrayEquals(instance.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2});
    }
}