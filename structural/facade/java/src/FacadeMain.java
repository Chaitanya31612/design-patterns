public class FacadeMain {
    public static void main(String[] args) {
      HomeTheaterFacade homeTheater = new HomeTheaterFacade();
      homeTheater.watchMovie("Inception");
      homeTheater.endMovie();
    }
}

/*
Projector is on
Streaming service is on
Sound system is on
Smart lights are on
Projector input set to Streaming Service
Sound system mode set to Surround Sound
Sound system volume set to 20
Smart lights are dimmed to 10%
Streaming service playing Inception
Projector is off
Streaming service is off
Sound system is off
Smart lights are off

*/
