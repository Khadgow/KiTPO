package model.usertype.prototype;

import model.comparator.Comparator;
import java.io.InputStream;

public interface UserType {
        public String typeName();

        public Object create();

        public Object clone(Object obj);

        public Object readValue(InputStream inputStream);

        public Object parseValue(String line);

        public Comparator getTypeComparator();
}
