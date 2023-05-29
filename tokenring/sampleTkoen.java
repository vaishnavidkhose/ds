import java.util.Scanner;

class sampleTkoen {
    public static void main(String[] args){
        System.out.println("enter no of processes:");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int sender,reciever;
        String msg;
        boolean msg_pass=false;

        System.out.println("Ring Initialised:");
        for(int i=0;i<n;i++){
            System.out.println(i);
        }

       
        System.out.println("enter sender:");
        sender = sc.nextInt();
        System.out.println("enter receiver:");     
        reciever = sc.nextInt();
        sc.nextLine();
        System.out.println("enter msg:");
        msg = sc.nextLine();
        
        for(int i=0;i<n;i++){
            System.out.println("token at position"+ i );
            
            if(i==sender){
                System.out.println("sender found at position" + i +" msg attached.");
                msg_pass=true;

            }
            else if(i==reciever){
                System.out.println("receiver found at position" + i +" msg received");

                msg_pass=false;
                System.out.println(msg);

            }
            if(msg_pass==true){
                System.out.println("msg passed from "+ i + " to "+ (i+1));
            }
        }
        



    }
}
