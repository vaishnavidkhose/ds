import java.util.Scanner;


public class bullycopy {
    static Boolean state[] = new Boolean[5];

    public static void up(int up)
    {
        if(state[up-1]==true){
            //already up
        }
        else{
            state[up-1]=true;
            for(int i=up+1;i<=5;i++){
                if(state[i-1]==true){
                    System.out.println("alive ,msg send from process"+ i+"to"+up);
                    break;
                }
            }

        }
    }

    public static void down(int down)
    {
        if(state[down-1]==true){
            state[down-1]=false;
        }
        else{
            //down
        }
        
    }

    public static void msg(int msg)
    {
        if(state[msg-1]==true){
            if(state[4]==true){
                //ok done
            }
            else{
                for(int i=5;i>=msg;i++){
                    if(state[i-1]==true){
                        //i'll be the coordinator
                        break;
                    }
                    
                }
            }
        }else{
            //already down
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ch;
        for(int i=0;i<5;i++){
            state[i] = true;
        }
        do{
            System.out.println("1. process up");
            System.out.println("2. process down");
            System.out.println("3. send msg");
            System.out.println("4. exit");

            ch = sc.nextInt();
            switch(ch){
                case 1:
                {
                    System.out.println("enter process to up:");
                    int up = sc.nextInt();
                    if(up==5){
                        System.out.println("5 is coordinator");
                        state[4]=true;
                    }
                    else{
                        up(up);
                    }
                    
                }
                case 2:
                {
                    System.out.println("enter process to down:");
                    int down = sc.nextInt();
                    down(down);
                    
                }
                case 3:
                {
                    System.out.println("enter process to send msg:");
                    int msg = sc.nextInt();
                    msg(msg);
                }
                break;
            }



        }while(ch!=4);

    }
}
