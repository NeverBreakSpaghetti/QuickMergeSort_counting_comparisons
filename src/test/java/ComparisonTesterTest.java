import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComparisonTesterTest {

    ComparisonTester comparisonTester = new ComparisonTester(0);;
    @Test
    public void comparisonsZeroElementsArraySortTest(){
        assertThat(comparisonTester.countComparisonsSort()).isEqualTo(0);
    }

    @Test
    public void comparisonsOneElementArraySortTest(){
        comparisonTester.setNElements(1);
        assertThat(comparisonTester.countComparisonsSort()).isEqualTo(0);
    }

    @Test
    public void comparisonsTwoElementsArraySortTest(){
        comparisonTester.setNElements(2);
        assertThat(comparisonTester.countComparisonsSort()).isEqualTo(3);
    }
}
