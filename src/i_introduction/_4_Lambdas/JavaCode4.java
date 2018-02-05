package i_introduction._4_Lambdas;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import util.JavaCode;

import java.util.Collection;

public class JavaCode4 extends JavaCode {
    public boolean task4(Collection<Integer> collection) {
        return Iterables.any(collection, element -> element % 2 == 0);
    }
}