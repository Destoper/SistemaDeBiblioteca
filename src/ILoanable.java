public interface ILoanable {
    public void receiveBookingRequest(User user);
    public void removeBookingRequest(User user);
    public int getNumAvailableCopies();
    
}
