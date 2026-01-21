# Mock REST API – Procesor Płatności

## Cel

Celem projektu jest **zaprojektowanie** REST API (bez jego implementacji) oraz przygotowanie:

* dokumentacji API (ten plik `README.md`),
* statycznego źródła danych (`json`),
* prostych atrap (mocków) zwracających dane z jsona,
* krótkich testów dla każdego endpointu.

API **nie istnieje realnie** – wszystkie odpowiedzi są wymyślone i mockowane.

---

## Tematyka API

**Procesor płatności** obsługujący:

* płatności,
* klientów,
* metody płatności,
* zwroty,
* wypłaty (payouts).

Bazowy URL (umowny):

```
https://api.mockpay.local/v1
```

---

## Modele danych (JSON)

### 1. Klient (Customer)

```json
{
  "id": "cus_001",
  "email": "jan.kowalski@example.com",
  "name": "Jan Kowalski",
  "createdAt": "2024-01-10T12:00:00Z"
}
```

### 2. Metoda płatności (PaymentMethod)

```json
{
  "id": "pm_001",
  "type": "card",
  "last4": "4242",
  "brand": "VISA",
  "customerId": "cus_001"
}
```

### 3. Płatność (Payment)

```json
{
  "id": "pay_001",
  "amount": 1999,
  "currency": "PLN",
  "status": "succeeded",
  "customerId": "cus_001",
  "createdAt": "2024-02-01T09:30:00Z"
}
```

### 4. Zwrot (Refund)

```json
{
  "id": "ref_001",
  "paymentId": "pay_001",
  "amount": 1999,
  "status": "completed",
  "createdAt": "2024-02-02T10:00:00Z"
}
```

### 5. Wypłata (Payout)

```json
{
  "id": "po_001",
  "amount": 150000,
  "currency": "PLN",
  "status": "pending",
  "createdAt": "2024-02-05T08:00:00Z"
}
```

---

## Statyczne źródło danych

Plik `data/mockData.json`:

```json
{
  "customers": [
    {
      "id": "cus_001",
      "email": "jan.kowalski@example.com",
      "name": "Jan Kowalski",
      "createdAt": "2024-01-10T12:00:00Z"
    }
  ],
  "paymentMethods": [
    {
      "id": "pm_001",
      "type": "card",
      "last4": "4242",
      "brand": "VISA",
      "customerId": "cus_001"
    }
  ],
  "payments": [
    {
      "id": "pay_001",
      "amount": 1999,
      "currency": "PLN",
      "status": "succeeded",
      "customerId": "cus_001",
      "createdAt": "2024-02-01T09:30:00Z"
    }
  ],
  "refunds": [
    {
      "id": "ref_001",
      "paymentId": "pay_001",
      "amount": 1999,
      "status": "completed",
      "createdAt": "2024-02-02T10:00:00Z"
    }
  ],
  "payouts": [
    {
      "id": "po_001",
      "amount": 150000,
      "currency": "PLN",
      "status": "pending",
      "createdAt": "2024-02-05T08:00:00Z"
    }
  ]
}
```

---

## Endpointy API (minimum 10)

### Klienci

1. **GET /customers** – lista klientów
2. **GET /customers/{id}** – szczegóły klienta

### Metody płatności

3. **GET /payment-methods** – lista metod płatności
4. **GET /payment-methods/{id}** – szczegóły metody płatności

### Płatności

5. **GET /payments** – lista płatności
6. **GET /payments/{id}** – szczegóły płatności
7. **POST /payments** – utworzenie płatności (mock – zawsze sukces)

### Zwroty

8. **GET /refunds** – lista zwrotów
9. **POST /refunds** – utworzenie zwrotu

### Wypłaty

10. **GET /payouts** – lista wypłat

---

## Przykładowe odpowiedzi endpointów

### GET /payments

```json
{
  "data": [
    {
      "id": "pay_001",
      "amount": 1999,
      "currency": "PLN",
      "status": "succeeded"
    }
  ]
}
```

### GET /payments/pay_001

```json
{
  "id": "pay_001",
  "amount": 1999,
  "currency": "PLN",
  "status": "succeeded",
  "customerId": "cus_001"
}
```

### POST /payments

```json
{
  "id": "pay_002",
  "status": "succeeded"
}
```
