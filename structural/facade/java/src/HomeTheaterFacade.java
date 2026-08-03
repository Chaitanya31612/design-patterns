import devices.*;

public class HomeTheaterFacade {
  Projector projector;
  StreamingService streamingService;
  SoundSystem soundSystem;
  SmartLights smartLights;

  public HomeTheaterFacade() {
    this.projector = new Projector();
    this.streamingService = new StreamingService();
    this.soundSystem = new SoundSystem();
    this.smartLights = new SmartLights();
  }

  public void watchMovie(String movie) {
    projector.on();
    streamingService.on();
    soundSystem.on();
    smartLights.on();

    projector.setInput("Streaming Service");
    soundSystem.setMode("Surround");
    soundSystem.setVolume(20);
    smartLights.dim(10);

    streamingService.play(movie);
  }

  public void endMovie() {
    projector.off();
    streamingService.off();
    soundSystem.off();
    smartLights.off();
  }

}
