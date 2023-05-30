# Import required modules
from timeit import default_timer as timer
from dateutil import parser
import threading
import datetime
import socket
import time

# Function for the client thread to send time to the server
def startSendingTime(slave_client):
    while True:
        # Provide the server with the current clock time at the client
        slave_client.send(str(datetime.datetime.now()).encode())
        print("Recent time sent successfully", end="\n\n")
        time.sleep(5)

# Function for the client thread to receive synchronized time from the server
def startReceivingTime(slave_client):
    while True:
        # Receive data from the server
        synchronized_time = parser.parse(slave_client.recv(1024).decode())
        print("Synchronized time at the client is: " + str(synchronized_time), end="\n\n")

# Function to initiate the slave client process
def initiateSlaveClient(port=8080):
    slave_client = socket.socket()

    # Connect to the clock server on the local computer
    slave_client.connect(('127.0.0.1', port))

    # Start the thread for sending time to the server
    print("Starting to receive time from server\n")
    send_time_thread = threading.Thread(target=startSendingTime, args=(slave_client,))
    send_time_thread.start()

    # Start the thread for receiving synchronized time from the server
    print("Starting to receive synchronized time from server\n")
    receive_time_thread = threading.Thread(target=startReceivingTime, args=(slave_client,))
    receive_time_thread.start()

# Driver function
if __name__ == '__main__':
    # Initialize the Slave / Client
    initiateSlaveClient(port=8080)
