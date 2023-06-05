package pojo.order;

public class GetOrderByTrackRequest {

    private int track;

    public GetOrderByTrackRequest(int track) {
        this.track = track;
    }

    public GetOrderByTrackRequest() {
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}
