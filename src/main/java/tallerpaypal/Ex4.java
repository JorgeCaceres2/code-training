package tallerpaypal;

import java.util.ArrayList;
import java.util.List;

// final global variable

public class Ex4 {
  private final List<String> foo;

  public Ex4() {
    foo = new ArrayList<>();
    foo.add("foo");
  }

  public void setFoo (List<String> foo) {
    //Compilation error

    //this.foo = foo;
  }
}
