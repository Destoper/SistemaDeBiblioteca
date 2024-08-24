public interface IReservable {
    public void receiveReservationRequest(User user);
    public void removeReservationRequest(User user);
    public int getNumAvailableCopies();
    
}
