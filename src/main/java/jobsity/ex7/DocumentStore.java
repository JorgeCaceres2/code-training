package jobsity.ex7;

import java.util.ArrayList;
import java.util.Collection;

public class DocumentStore {

  private final Collection<String> documents = new ArrayList<>();
  private final int capacity;

  public DocumentStore(int capacity) {
    this.capacity = capacity;
  }

  public int getCapacity() {
    return capacity;
  }

  public final Collection<String> getDocuments() {
    return documents;
  }

  public void addDocument(String document) {
    if (this.documents.size() >= capacity) {
      throw new IllegalStateException();
    }

    documents.add(document);
  }


  @Override
  public String toString() {
    return String.format("Document store: %d/%d", documents.size(), capacity);
  }

  public static void main(String[] args) {
    DocumentStore documentStore = new DocumentStore(2);
    documentStore.addDocument("item");
    System.out.println(documentStore);
  }
}
