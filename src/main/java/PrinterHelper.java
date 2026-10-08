
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PrinterHelper {
    public static void main(String[] var0) {
        String var1 = "print_me.txt";
        int var2 = 1;

        String var3;
        for(var3 = "formatted_receipt" + var2 + ".txt"; Files.exists(Paths.get(var3), new LinkOption[0]); var3 = "formatted_receipt" + var2 + ".txt") {
            ++var2;
        }

        try {
            String var4 = new String(Files.readAllBytes(Paths.get(var1)));
            PrintWriter var5 = new PrintWriter(var3, "UTF-8");
            printSmartReceipt("MY NOTES", var4, var5);
            var5.close();
            System.out.println("SUCCESS! Open 'formatted_receipt.txt' to print.");
        } catch (IOException var6) {
            System.out.println("ERROR: " + var6.getMessage());
        }

    }

    public static void printSmartReceipt(String var0, String var1, PrintWriter var2) {
        byte var3 = 32;
        byte var4 = 32;
        int var5 = 1;
        int var6 = 0;
        var1 = var1.replace("\r\n", "\n").replace("\r", "\n");
        ArrayList var7 = new ArrayList();
        String[] var8 = var1.split("\n");

        for(String var12 : var8) {
            if (var12.length() == 0) {
                var7.add("");
            } else {
                for(int var13 = 0; var13 < var12.length(); var13 += var3) {
                    int var14 = Math.min(var13 + var3, var12.length());
                    var7.add(var12.substring(var13, var14));
                }
            }
        }

        for(int var17 = 0; var17 < var7.size(); ++var17) {
            if (var6 == 0) {
                printHeader(var0, var5, var2);
                var6 += 4;
            }

            if (var6 >= var4 - 2) {
                printFooter(var5, var2);
                var2.println("\n--- TEAR HERE ---\n");
                ++var5;
                var6 = 0;
                printHeader(var0, var5, var2);
                var6 += 4;
            }

            var2.println((String)var7.get(var17));
            ++var6;
        }

        while(var6 < var4 - 2) {
            var2.println("");
            ++var6;
        }

        printFooter(var5, var2);
        var2.println(".");
    }

    public static void printHeader(String var0, int var1, PrintWriter var2) {
        var2.println("================================");
        var2.println(var0.toUpperCase() + " [Pg " + var1 + "]");
        var2.println("================================");
    }

    public static void printFooter(int var0, PrintWriter var1) {
        var1.println("================================");
        var1.println("      END OF PAGE " + var0);
    }
}
