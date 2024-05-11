import java.io.IOException;

public class Addition {

    public static void main(String[] args) throws IOException {
        if (args.length > 0)
        {
            if (args.length == 1) System.out.println("Only one number hence cant be added");

            if (args.length == 2) {
                String a1 = args[0];
                int v1 = Integer.parseInt(a1);

                String a2=args[1];
                int v2=Integer.parseInt(a2);

                int sum=v1+v2;
                System.out.println("Sum is "+ sum);
            }

            if(args.length>2)
            {
                System.out.println("More than two number enetered ! Enter only two.");
            }
        }
        else {
            System.out.println("No numbers to Add");
        }
    }}
