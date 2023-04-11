package jobsity.ex5;

public class DocumentCounter {
  public static abstract class AbstractDocumentCounter {
    private int count = 0;
    private int increment;

    public AbstractDocumentCounter(int increment) {
      this.increment = increment;
    }

    protected int getAndIncrement() {
      this.count += this.increment;
      return this.count;
    }

    public abstract String getNewDocumentName();
  }

  public static class DocumentNameCreator  {
    private String prefix;
    private int count = 0;

//    public DocumentNameCreator(int increment, String prefix) {
//      this.count += this.increment;
//      return this.count;
//    }
//
//    public String getNewDocumentName() {
//      return prefix + getAndIncrement();
//    }
  }


}
