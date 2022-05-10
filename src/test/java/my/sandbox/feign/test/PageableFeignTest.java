package my.sandbox.feign.test;

import my.sandbox.feign.clientSide.PageableFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PageableFeignTest {
    private static final int TEST_PAGE = 1;
    private static final int TEST_SIZE = 25;

    @Autowired
    PageableFeign client;

    @Test
    public void mirrorCallTestWithoutSort() {
        // given
        var pageable = PageRequest.of(TEST_PAGE, TEST_SIZE);

        // when
        var result = client.mirror(pageable);

        // then
        assertNotNull(result);
    }

    @Test
    public void mirrorCallTestWithSort() {
        // given
        var pageable = PageRequest.of(TEST_PAGE, TEST_SIZE, Sort.by("documentDate").descending());

        // when
        var result = client.mirror(pageable);

        // then
        assertNotNull(result);
    }

    @Test
    public void mirrorCallWithPageableDecomposition() {
        // given
        var pageable = PageRequest.of(TEST_PAGE, TEST_SIZE, Sort.by("documentDate").descending());

        // when
        var result = client.mirror(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                sort2StringCollection(pageable.getSort()));

        //then
        assertNotNull(result);
    }

    private Collection<String> sort2StringCollection(Sort sort) {
        var result = new ArrayList<String>();
        if (sort != null) {
            var iterator = sort.iterator();
            while (iterator.hasNext()) {
                var order = iterator.next();
                result.add(String.format("%s,%s", order.getProperty(), order.getDirection().name()));
            }
        }
        return result;
    }

}
