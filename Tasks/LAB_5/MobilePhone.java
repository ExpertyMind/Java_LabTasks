package Lab_Work.LAB_5;

public class MobilePhone implements Camera, Microphone, GPS {

    @Override
    public void TakePhoto() {
        System.out.println("Photo Clicked");
    }

    @Override
    public void TakeVideo() {
        System.out.println("Video Started Recording");
    }

    @Override
    public void startTracking() {
        System.out.println("GPS is now Turned On");
    }

    @Override
    public void stopTracking() {
        System.out.println("GPS is now turned Off");
    }

    @Override
    public void StartRecording() {
        System.out.println("Audio Recording has Started");
    }

    @Override
    public void StopRecording() {
        System.out.println("Audio Recording has Stopped");
    }
}
