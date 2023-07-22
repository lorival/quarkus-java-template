package br.com.lorival;

public class GreetingResource implements GreetingApi {

  @Override
  public String getGreetingMessage() {
    return "Hello";
  }
}
