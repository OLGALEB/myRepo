import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppRunner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Map<String, String> replaceValue = new HashMap();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter transaction id: ");
        String transactionId = in.nextLine();
        replaceValue.put("transaction_id_placeholder", transactionId);

        System.out.println("Enter action:");
        String action = in.nextLine();
        replaceValue.put("action_placeholder", action);

        System.out.println("Enter currency code:");
        String currencyCode = in.nextLine();
        replaceValue.put("currency_code_placeholder", currencyCode);

        System.out.println("Enter dispute amount:");
        String disputeAmount = in.nextLine();
        replaceValue.put("amount_placeholder", disputeAmount);

        System.out.println("Enter dispute type:");
        String disputeType = in.nextLine();
        replaceValue.put("dispute_type_placeholder", disputeType);

        System.out.println("Enter dispute reason:");
        String disputeReason = in.nextLine();
        replaceValue.put("dispute_reason_placeholder", disputeReason);

        System.out.println("Enter PM sybtype (e.g.MasterCard or paypal_account):");
        String pmSubtype = in.nextLine();
        replaceValue.put("dispute_reason_placeholder", pmSubtype);

        String payloadField = CreatePayload.decodeXmlNotificationToPayload(replaceValue);
        System.out.println("created payload: " + payloadField);

        String signatureField = new CreatedSignature().signatureGenerate(payloadField);
        System.out.println("created signature: " + signatureField);

        System.out.println("Notification response code: " + new PpsClient().sendDisputeToPPS(payloadField, signatureField, new HashMap<String, String>()).getStatusLine());
    }
}