package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P5_BalancedParentheses.Java;

public class ParenthesesString {
  String str;
  int openCount; // open parentheses count
  int closeCount; // close parentheses count

  public ParenthesesString(String s, int openCount, int closeCount) {
    str = s;
    this.openCount = openCount;
    this.closeCount = closeCount;
  }
}