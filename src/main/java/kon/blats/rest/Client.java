package kon.blats.rest;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by k.blatsoukas on 10/24/2017.
 */

public class Client {

    public static void main(String[] args) throws IOException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Runnable task = () -> {
            try {
                sendTransaction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 13, TimeUnit.MINUTES);
    }

    public static void sendTransaction() throws IOException {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("apiuser@ifg.com", "aFw92H@Fb1");
            provider.setCredentials(AuthScope.ANY, credentials);
            HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
            HttpPost httpPost = new HttpPost("http://35.190.25.70:80/v2/order");
            String json = getJsonExample();
            StringEntity entity = new StringEntity(json, "application/json","UTF-8");
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            System.out.println("Transaction sent!!");
            HttpResponse response = client.execute(httpPost);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getJsonExample() {
        return "{\n" +
                "\"orders\": [\n" +
                "    {\n" +
                "    \"flightRecords\": [\n" +
                "        {\n" +
                "            \"routingDIIndicator\": \" \",\n" +
                "            \"passengerRecord\": {\n" +
                "                \"name\": \"TIWARI/VIRAJMR\",\n" +
                "                \"typeCode\": \"CNN\",\n" +
                "                \"PNR\": \"RFLLEU/F1\",\n" +
                "                \"dateOfBirth\": \"20140102\"\n" +
                "            },\n" +
                "            \"documentID\": {\n" +
                "                \"airlineCodeCRC\": \"3\",\n" +
                "                \"ticketDocumentNumber\": \"0741827456000\",\n" +
                "                \"ticketingAirlineCodeNumber\": \"074\",\n" +
                "                \"ticketCRC\": \"2\",\n" +
                "                \"ticketingModeIndicator\": \"/\",\n" +
                "                \"couponUseIndicator\": \"FVVV\"\n" +
                "            },\n" +
                "            \"documentDetails\": {\n" +
                "                \"emdDetails\": [\n" +
                "                    {\n" +
                "                        \"couponNumber\": \"1\",\n" +
                "                        \"couponValue\": \"00000002500\",\n" +
                "                        \"currency\": \"EUR2\",\n" +
                "                        \"relatedTicketDocumentNumber\": \"0745696282218\",\n" +
                "                        \"relatedCouponNumber\": \"0\",\n" +
                "                        \"serviceType\": \" \",\n" +
                "                        \"reasonforIssuanceSubCode\": \"993\",\n" +
                "                        \"feeOwnerAirlineDesignator\": \"MI\",\n" +
                "                        \"consumedAtIssuance\": \" \",\n" +
                "                        \"numberOfServices\": 1,\n" +
                "                        \"industryCarrierIndicator\": \" \",\n" +
                "                        \"remarks\": \"REBOOKING FEE INTERNATIONAL\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"dateOfIssuance\": \"20170801\",\n" +
                "            \"timeOfIssuance\": \"16:11:00\",\n" +
                "            \"automaticRepricingEngine\": \" \",\n" +
                "            \"statisticalCode\": \"I\"\n" +
                "        }\n" +
                "    ],\n" +
                "      \"reportedFormOfPayment\": [\n" +
                "        {\n" +
                "            \"amount\": 33600,\n" +
                "            \"currency\": \"EUR2\",\n" +
                "            \"type\": \"CA\",\n" +
                "        \t\"address\": {\n" +
                "            \"city\": \"Chania\",\n" +
                "            \"countryCode\": \"GR\",\n" +
                "            \"houseNumberOrName\": \"None\",\n" +
                "            \"stateOrProvince\": \"\",\n" +
                "            \"street\": \"L. Soudas\"\n" +
                "          },\n" +
                "          \"payer\": {\n" +
                "            \"email\": \"string\",\n" +
                "            \"firstName\": \"John\",\n" +
                "            \"id\": \"string\",\n" +
                "            \"lastName\": \"Doe\"\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"monetaryAmounts\": {\n" +
                "    },\n" +
                "    \"additionalInformation\": {\n" +
                "        \"paymentInformationLine1\": \"CASH\",\n" +
                "        \"paymentInformationLine2\": \"\"\n" +
                "    },    \n" +
                "    \"additionalSalesInformation\": [\n" +
                "        {\n" +
                "            \"fare\": \"EUR25.00\",\n" +
                "            \"total\": \"EUR25.00\",\n" +
                "            \"fareCalculationModeIndicator\": \"1\",\n" +
                "            \"fareCalculationPricingIndactor\": \"1\",\n" +
                "            \"fareCalculationArea1\": \"ZAG LX ZRH336HRK336END\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"bookingInformation\": {}\n" +
                "    }\n" +
                "]        \n" +
                "    ,\n" +
                "    \"basicInformation\": {\n" +
                "        \"countryCode\": \"FR\",\n" +
                "        \"transactionCode\": \"EMDS\",\n" +
                "        \"agentCode\": \"2021586\",\n" +
                "        \"reasonForIssuanceCode\": \"C\",\n" +
                "        \"channel\":\"NONGDS\",\n" +
                "        \"clientID\": \"074\",\n" +
                "        \"recordType\": \"EMD\",\n" +
                "    \t\"pnrReport\": true\n" +
                "    },\n" +
                "    \"formOfPayment\": [\n" +
                "        {\n" +
                "          \"amount\": 33600,\n" +
                "          \"currency\": \"EUR2\",\n" +
                "          \"type\": \"CA\",\n" +
                "          \"address\": {\n" +
                "            \"city\": \"Chania\",\n" +
                "            \"countryCode\": \"GR\",\n" +
                "            \"houseNumberOrName\": \"None\",\n" +
                "            \"stateOrProvince\": \"\",\n" +
                "            \"street\": \"L. Soudas\"\n" +
                "          },\n" +
                "          \"payer\": {\n" +
                "            \"email\": \"string\",\n" +
                "            \"firstName\": \"John\",\n" +
                "            \"id\": \"string\",\n" +
                "            \"lastName\": \"Doe\"\n" +
                "          }\n" +
                "    }    \n" +
                "  ]\n" +
                "}";
    }

}
