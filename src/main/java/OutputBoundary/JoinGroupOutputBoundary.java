package OutputBoundary;

public interface JoinGroupOutputBoundary {
    /**
     * @param status join status.
     */
    void setJoinGroupName(String status);

    /**
     * @return join group chat message.
     */
    String presentOutput();
}