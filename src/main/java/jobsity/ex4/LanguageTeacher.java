package jobsity.ex4;

public class LanguageTeacher extends LanguageStudent {

  private String language;

  public LanguageTeacher (String language) {
    super();
    this.language = language;
  }

  public boolean teach(LanguageStudent student, String language) {
    if (this.language.equals(language)) {
      student.addLanguage(language);
      return true;
    } else {
      return false;
    }
  }
}
