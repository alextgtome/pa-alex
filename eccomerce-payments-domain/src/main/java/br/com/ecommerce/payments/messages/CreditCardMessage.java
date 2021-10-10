package br.com.ecommerce.payments.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardMessage {

  private String cardNumber = null;

  private String holder = null;

  private String expirationDate = null;

  private String securityCode = null;

  private String brand = null;

}

