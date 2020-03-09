package Step_Project_1.controllers;

import Step_Project_1.services.Service;

public class Controller {

  Service service = new Service();

  public String showMenu() {
    return service.getMenuContents();
  }

  public String getOnlineBoard() {
    return service.getAllInfoForOnlineBoard().toString();
  }
}
