import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComparisonTesterTest {

    @Test
    public void comparisonsZeroElementsArraySortTest(){
        ComparisonTester comparisonTester = new ComparisonTester(0);
        assertThat(comparisonTester.countComparisonsSort()).isEqualTo(0);
    }
}
