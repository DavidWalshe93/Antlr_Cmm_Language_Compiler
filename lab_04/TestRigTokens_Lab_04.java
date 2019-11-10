

public class TestRigTokens_Lab_04 {

    public static void main(String... args) throws Exception {
        org.antlr.v4.gui.TestRig.main(new String[]{"parser.Cmm", "program", "-tokens", args[0]});
    }
}
