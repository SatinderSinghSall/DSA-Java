# Data Structure and Algorithms: DSA - Java

---

# 🚀 Dynamic Programming in Java

### _From Recursion → Memoization → Tabulation_

![Java](https://img.shields.io/badge/Language-Java-orange)
![DSA](https://img.shields.io/badge/Focus-Data%20Structures%20%26%20Algorithms-blue)
![DP](https://img.shields.io/badge/Topic-Dynamic%20Programming-green)
![Level](https://img.shields.io/badge/Level-Beginner%20to%20Advanced-purple)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

## 📌 Overview

This repository presents a **structured and progressive study of Dynamic Programming (DP)** using Java, covering:

- Recursive approach (baseline)
- Memoization (top-down optimization)
- Tabulation (bottom-up optimization)
- Core DP problems:
  - Climbing Stairs
  - Fibonacci Numbers

---

## 🧠 What is Dynamic Programming?

Dynamic Programming is a method for solving problems by:

- Breaking them into **overlapping subproblems**
- Storing results to avoid recomputation
- Building efficient solutions using **optimal substructure**

---

## 📊 DP Concept Flow

![Image](https://images.openai.com/static-rsc-4/kkXw1HWsw6yaTBQY8TI2mf2YNMjq1vnnkjQ0dRfoYv_X-7A1bAtdzlFXi90qTbB_-er8ZAiPb-4DF_b1Q48aNgdaUt8lOY62o-Ru7n59sy13GEWfZnUIpRY9N0yCUTA8iYaS1d3jmTmGgNukndnABKAp3ObfA_fOZbb2IJsOPGaagzsg9HYq3VHQ6YufwoJn?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/17wtmNkZ2lYalMQPKVnq6C1xsJ9anf7LXCEM-Obb6tBkDjn1cwoJw2UBqsgmQl7-odB7sVeZ-_S6x14Zs7TP-N-JOvv4bQlI9LzCuikm8X9dTdzN1UvrcBuCPEdVgkBYY2C_CrHObrAwmaU3YAxMFgVYI-QOihgGysJAiUhLq8Ods41sM5xNXZNdPFmN5nh7?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/FqWZrdh8DiiNQthBUReTowcOZvsJdKcI-FkYcApwQfD46BQqYb11LV4U0ANKB6xr4mW5b0_By5Mvokw-now9T3nDjyximzU2aWfluRbP1LVNrHUSH2miYsQfbLbM-mnd6I3vmSUeqb8awh9l-yCMC_J_Pueawdci0_8VZADj7pW6J96NZXa0yhGLC9cCu8JE?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/EIe-RUOxtOXPFX0C4yNHgCBHohdiNG_hgrpqx7OqUCa8ZrzkqOYsyVrnPrfyWm_hwgAnNxt4xkWx_lVM0tbIPHCTdFXpiPCcQfr6HfLWXDmJAcGuXYBuma5smwCxt7z0egxTTkGIS1tkbz2Lzb02Fj7zSVI4RT410Kpc4dc-294Dvsp8FG_hqnZCKmWtFEPn?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/rjZA4HcL1GNyI1WQDTQIua4Q6xf4FHHP4d7t4wX5ZgrWNOVayUjxvPiG77XG1wjMbg88YWLpzsXVEVBNMBJiuXcnqsQQqIacqj35PDLZUb9L8cC3xZCIABtAGUaJdCcyZ4EMzxa98tzz9Y6rnGXfR-kVOLgTeU766_srBHy--vxzJUTy6S8vooeyWTh_6aBF?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/BPEOdSCn0eUdZALhcu53-iC0gF9aywefd7_2cr2xx0N_Xzd9PmqLz0pMFAUmy64UsYkGuc5C2PwqkxahN2jeBPMxlyCPwseVQIV7HAfjI9IPqf3FEMfktsc5LZWlBp8dz55_CH83-ksaVbaYUxDW597HlIz0EhVtrhapkFmO6xMsYWcuhWPjHfQXPCBSxopI?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/2sv8A6b5NzuZn1dPUVcZcyvz49lHs7BsmlX22ta7Mx9bz_FtveInUhAhN8mxuFjE2vVHVMIverlUVm3OwM3Z7-SRuMv7NDgC70jtfVQRnPT53AQNvWgwLy0rhs2qRAJpc57YX_dHQTb4uO2A2g5BsMzHNHUWHKDUT1QhWb6xNuTWbFKclMJUa5VoelFr0bGP?purpose=fullsize)

---

## 🧗 Problem 1: Climbing Stairs

### 📌 Problem Statement

Given `n` stairs, you can climb:

- 1 step
- 2 steps

Find total number of ways to reach the top.

---

## 🌳 Recursion Tree (Why it's inefficient)

![Image](https://images.openai.com/static-rsc-4/98P4c49VfLVv_AALMlwIavDUkDb3Zepg2E6hpKUsfws9uuluHnu1-27VJ774_M3FzprNyk6AdgJLDnoPh4I_CGkAS-YRCrcDcKkBTXLnucs_MBwCFisxTSZkTCmeehgY8RUQEVFFFzerC-7kTdszkIlmvovMPf23lo-FCQ_LnvkZ23ltLM3hI-DDOMVzZGXD?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/qCFaRKTdAAkXebHCXDxpXsHWSw1ifBKr7o-DQWS5jfnMa8XH6Pb0pCTfbt9DMph2Pcc2Icohwvi50wF15mxAN5G_9XEddjEwzp_FnL4leEhO1bwAcYImUog1Si3iun9qNtEoDD6MbuYongSILZHXprUsy7wHOpjl0ls4fOyVMBH-HTMJSxDYpLcSv62dybJ6?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/M9dJguCkn6kvgdMZrO-YLSSLdMUTDL0B4-tNAE9XzNpjS0lNj7R1RtT8OYBXSkiTRUsM2oJndMdhFeKDuDNU3A2hX592snbJ2HQRRM_-MqYirbyiDHVgpmhcERvA4apL9tm88SEDCLYm4MPTP2-DYOVKHWlByKQmaza4JtqorvMrBuLowwuZp7gliZGFscRR?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/jSFSgULsIfO6aCP71K97CD8z1MiWE9iH2VesNFXRr35ueEH-y-5AShpREm2ip9HLg9-CFeR4WvghWtIgBTX2Ea9x-VJrBG71-Ku4SVzsyuh_2LGdJVAu0QWu28qtqMaesnZyFDOHMDP5iGbPIGLAbRrcQyMUa0exWpd3lr25lXTkoF4k9AGXXRGMhbxhM50M?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/PMKgg_loQV0x9023cTE9F99_zu2H-ChxFFxtArfU6aGyA0XzB2GalkkJstII6BIVwjzLamq0bYHi6GRehLttfrVzLIQLE1hSxfbcdrl4ZSxRRlodVS7GcZuPijujEIPMHgwA4cbdc8TePQGeiJGJ_AVfgYfW4biOkmcg-CEkbKyjYKVPO3WEQGxRPvATzyxs?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/SnyuZ_7s0ThsnXNpl8fmij_1J1h3ljyJDN2QEvPYhR0LbRrBAqW3w2PTndk-U038UXjBY6iQUga9vwdKSOVA-m5OEHQF6Vyb5FtA4-nqx9eJ4__1VyU4DAmWB_ToNSsmnOEhHMAOJQw4t-BjVAccBhQppQDipuMhgsa-hnI0_013Nt49d6NBX50A_SdqXQLP?purpose=fullsize)

---

### 🔁 Recursion Approach

#### Algorithm

- Break into smaller subproblems
- Combine results

#### Recurrence Relation

```
ways(n) = ways(n-1) + ways(n-2)
```

#### Code

```java
public static int countWays(int n) {
    if (n == 0) return 1;
    if (n < 1) return 0;

    return countWays(n - 1) + countWays(n - 2);
}
```

📄 Source:

---

### ⚡ Memoization (Top-Down DP)

## 📊 Memoization Visualization

![Image](https://images.openai.com/static-rsc-4/otciaMHjwKbNInUy8nrqlA_V66dEtKFi4_YUcnoABa94kDcQK7mhtvz5RRAC4EtyuADGK2Z7wWyFT60V-UW0o6VDVPZQHSAUYg3JuEN_t4ioO6YnYie3avslrmFiIqZTHN2Y5EblSMgvqvJrogpQOJMMi0C-6pUU_OusqyssGuU3utHb3h3raBT5bjCtuoNJ?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/fZyc9DOhy4SNrgKeEV-HDxrMOPLh0-dsDq-dz14mTWiA2oXvwhJGfBH5zv89Fi-BVpUB-jE21L0SUv2dwwZaj-YqBEQ1525aOIGUcBkGsjiI65OqyCAcdPt-KqEr8r7ManQTgpFJOkskSZiPKxaobk9OFww54tNbcEtcNfBmi8hyXiYr_QUpuEQNn4f4TZoa?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/GVUdqm0vcddqjhmWZlaR4yfJouN8GxFUf7N9hiyiELbJViWtjTUBVZCnHK4j0p5UuMLCqL3GLE8Rif15v7bNkZ80j8ppqIf6sxXcIlPs15MWPgSm7Qrcl7t4RpGbqs-NfFYJuFBB8en30EcBjY9P6z7CHdn9L0fM_GKrgi9-Yxb7JvyqEpRDCBg_UeNvwCbN?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/FvdQcTLsuGwlLKdRxt4DHCWnid1BNOO8YXV7JMpCI2mSzzbyDrDw9O5fJ4vynik8JArXCtO4Gv0FUFvEOtbFJMsOneoC9wrdc7RhV614oAnUzDrKRymQA_jAI_SAJeBn4YdM9gWDNMCGgqa1eWi0uvE4y1E6BT0yxVfbvVflLXNcWDQ6sorMZuYycfLyjLkY?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/L5FHMM4S62UNczpy3z77PovwAPldnEUBH6CkL-z_imHF0Tbd7k1rW2_-puqG_AHw4-1mI1Rks9rZX7hge7hJRBFtqHlTzBeYarH8yyquSdUVo1ZIQbMs0QHjBm-zlK8MNWsUg8GpuSrHJBM4fyN3lO85gC6yjIYOo2CK3R6LdQ4qA5BnOdGL1hoKSVbb1ZMS?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/kld63K4NeBdbTMqwZpobWgXa_n1TXM201t8HWPiT6y1meaxGYW7Z96zKsWtnof4AX-4Mzm5dkz74M7g-VlC4O5viHMqHiSs3wwlbhwUNi-Jjo_9H0DwbzSIKr3by32PudRm_KWIAI4LvHSNxRXuciQpkJs-vyQC3fZtEvlhY59qZ67Oe5Ceyfur1QYX6xW8O?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/LwWEId3SleA0U7cXMpxO78iojxnEl8z3thClDJFrVSIdf-ACkqHsnYSbKke8jvhmxricEiSl6xKJCu-Kzydz0rym0lyNOKd0jzYM31PKThD-VHXBSySWCoP82jXMMC2PtBrF_GX-1Gi0CKJ1_9IcwXe1PRijHrjTNw_myyj3QvNratWs6OQbK12r15nzCbLn?purpose=fullsize)

#### Algorithm

- Use array to store results
- Avoid recomputation

#### Code

```java
public static int countWays(int n, int ways[]) {
    if (n == 0) return 1;
    if (n < 1) return 0;

    if (ways[n] != -1) return ways[n];

    ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
    return ways[n];
}
```

📄 Source:

---

### 📊 Tabulation (Bottom-Up DP)

## 📊 Tabulation Table Build

![Image](https://images.openai.com/static-rsc-4/AEUXmqsRbOhWEp2eCYeR0YkN7Ackv9za4jY8Qe0ku8IOPHvY2mqS_Ky42OPHjkZjFAVm93lY3_5fCFxt1GvAkTAFmvVB__TYsax4UnqSMay3uVTsclyYwagLpOtVVMPz97ibrQgLoX7q32dq_zq8tNEIDCxI7wOiPigY1O7jctAcwPu1ZaYUgRa_XwmeK2e2?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/VpEEI92JsgZuT4sEODusVv114noL6wi2t53SYE4JkpfAkSQoG61uLLJ3vifYzFYUZAJU0nSJibYP4fugQD4GMmJ4gHT8kK_vSxxXqb3fucufCFsAX6nVRaHHpAW2Crh1gDtOXKL7qd8g39EiZ1hn6RN2f8xmavJrOmBEOsU9_DVBk8eTNh5oJKUzA5hoaZBw?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/ydvn2UCFKXEiy9tTJmD4lToQPyWRlD1yymCSIlJ3t7Zs6ltrky5qYpbdlVF2z5eGpq7TGicOtdZYmQ0dQn81-lWrxQM8EMMew7mQCf6vGHPr1CmANRxbCN_5-8Z8lMjaHA9y9l_XgYuAoWSWl8lNBXqqjnhiCeWB4558YazOHmF7n-kvkMWlc04eXtUWSuem?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/SUyYgIR1CuWOJwm2IsNQngbo7ExHgR3-YZJpdf9LqJHOsNjwJooPHCwF5yaBLfoI8QeZbUR1RudtrqO7-HEqf28wgwCVk--WL79dS1ncYnMbleuwhAZYPwn-fuYmp8m5E4QYkV1kyDverh1pcCkX720e6u1Qg6WbXOhItZGSMjZjVFL402DlHoNRalaveu68?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/mmdVyqrzf3HQvryqM3yuMxiiUL0Ia-KJ0zCk2M6Vl1PIYL0TjHm4qd8Xj6UxO1omGweu7rNEmQDEntecqPcXMpwXF9RNjcJb1On6DOFEXAGYMisLp5K8ozWrlLYZTNnYfKtYAL30hKYszg194o_UPfs5xjv6C12Jd-qAYdkIIRIkfCSSxTKTc4j0P6ORoWqH?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/hRNdhjfHcftS2b9g_WsUHSu4_W_4KWxG-kEZs1AJziIBwPb32wPAPFBOt7RnqVrWJZxDjyaTM8N-d6s3KLVhCSY2fgbyQHpL1alXoXdGZC5czQfrwqZZpd9em2fMEJ28s0c-IBsccbTT5Gpl_jp3ZUIWUeuOykcy1sX7RBkKjmiImzCL-4Ozvc6DtmaTdHTv?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/pPKp9HHk6CNTncIGQz8T88WrqseEnNB8jp3rBmb12qktb_97m6G0UvbGtcWsLHTGE9hGE3nzvABQ0uQICBWn3H7gf5a3KBJosxU_p-ofU81L3NgJeatpkUaZF2d5Wi4O0esZ-cvd7zvQIvFRHQizFSElQhYl4zjyq6WKHtLcrVhbdwsdIvu8JHZpXdAHyXmW?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/JvbreNqch2354pRw2OY7dgno2wrqL3d-5CyoP0XyK2Y-VgM7nxUYNDyGNf85QFn8p7tv01K0q4iJ56ETEH7O7CFtMDwO78RXtSNsu1fACkLZ4Drk900fOtibp_jg61ej6l0lqoCbTz58OffJdoSwslXORZ9I-O0bHdcRNLIFSf7wzHrC_6EQPV5yFyAue-iw?purpose=fullsize)

#### Algorithm

- Build solution iteratively
- Start from base cases

#### Code

```java
public static int countWaysTab(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
        if (i == 1) {
            dp[i] = dp[i - 1];
        } else {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
    return dp[n];
}
```

📄 Source:

---

## 🔢 Problem 2: Fibonacci Numbers

### 📌 Problem Statement

Find nth Fibonacci number:

```
F(n) = F(n-1) + F(n-2)
```

---

## 📊 Fibonacci Visualization

![Image](https://images.openai.com/static-rsc-4/1RPEOrRsEinJSIFrQ7ZLi381j-ejze9Dxwg_KeFVfpyahW0KjUUmZO9QIiqmO1BtDHGBEu23H4dwxcJ6ImVj6Lu7cpLCXU1SRYtk7cGLsuVM4EPWAhWqrfP241ftaUqHtky8bj6wUyBdKuIvStz4FtgNXVjNTUoDRoUffDZ-zUrSS9ZVL43blInRJWnCDQ1m?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/SUyYgIR1CuWOJwm2IsNQngbo7ExHgR3-YZJpdf9LqJHOsNjwJooPHCwF5yaBLfoI8QeZbUR1RudtrqO7-HEqf28wgwCVk--WL79dS1ncYnMbleuwhAZYPwn-fuYmp8m5E4QYkV1kyDverh1pcCkX720e6u1Qg6WbXOhItZGSMjZjVFL402DlHoNRalaveu68?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/IpBS7x7vX5tByH7AYnrVvshhjyXEu96_XrkJmqd-fp7IZIwh6diptKP6bMiFAxUwz9oQLztrzw70KKBvQVlPGD2W0W2csnldrxiQX5vLS_4oX0cev8IQ2H3YZTVMSdpMz_SZbXVVhSksP3jly6hGUYy0WvEa_EjYPhYjF-M-b-lM7pXDDeWcjmPaYUJ1j_pn?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/fHb0dYhra50yBphCsKMeQUTmWM1ax_exbM8TLVuWbZcqU4UcIrESPC5y4l6KH6xWGbVBUec__YAOPaI7jGhTBm0j-570Yy-Mn1cH3aDu7i_3jubCQmVw5jPbZojxpQ0NsAEJoSHDz-7wCAO7Zz3txeX03rsBSYfbE3mHj2rv8CEHnPrgYjnHXg37e0cac_C6?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/4-I_g-geJBcg3WEVBbUFkXjAQnx4GISpxzLyXmlDf2C0PjVFxsM9WX4W3-XhIeToAumLSjL-v9iUYEjArEtCzyszxi4yt7NWltjM-tNyonZdemuWGAGTJiL68NaU_XBWsXomatNc6i3lrj-_J5UwTF6lYmx8CUyMNIQ8gNMguW8MqOxAhO2Vb2f8OeuYMrKb?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/M3eAFSAz4bpfMAOVk6Oagj7GUI5V3a2BOf6QuiL_qyv60_NTiZ_Ylj8_HjfBhJ7HFSfyl8apRj0R338L2ktv4CKNOe6v36sPRvnp0iLRrmLBoJFvliEw8NmOSb4-zhRiDL2KCB1hFJwrpBKm12GaQOiKqu792CQt9B2GttiBFEtwfyJ7LG-D6x34I4NiYCmw?purpose=fullsize)

---

### ⚡ Memoization

```java
public static int fibonacci(int n, int f[]) {
    if (n == 0 || n == 1) return n;

    if (f[n] != 0) return f[n];

    f[n] = fibonacci(n - 1, f) + fibonacci(n - 2, f);
    return f[n];
}
```

---

### 📊 Tabulation

```java
public static int fibonacciTabulation(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

📄 Source:

---

## 📈 Complexity Comparison

| Approach    | Time  | Space | Performance |
| ----------- | ----- | ----- | ----------- |
| Recursion   | O(2ⁿ) | O(n)  | ❌ Poor     |
| Memoization | O(n)  | O(n)  | ✅ Good     |
| Tabulation  | O(n)  | O(n)  | 🚀 Best     |

---

## 🧩 Repository Structure

```
📦 Dynamic-Programming-Java
 ┣ 📜 ClimbingStairs_Recursion.java
 ┣ 📜 ClimbingStairs_Memoization.java
 ┣ 📜 ClimbingStairs_Tabulation.java
 ┣ 📜 FibonacciNumber.java
 ┣ 📜 Main.java
 ┗ 📜 README.md
```

---

## 🎯 Learning Outcomes

- Understand **why recursion fails at scale**
- Learn **DP optimization techniques**
- Master **top-down vs bottom-up**
- Recognize **Fibonacci patterns in problems**

---

## ▶️ How to Run

```bash
javac ClimbingStairs_Tabulation.java
java ClimbingStairs_Tabulation
```

---

## 🌟 Future Enhancements

- 🔥 0/1 Knapsack
- 📏 Longest Common Subsequence (LCS)
- 📈 Longest Increasing Subsequence (LIS)
- ⚡ Space Optimization (O(1) DP)

---

# 👨‍💻 Author

**Satinder Singh Sall**
Data Structures and Algorithms
Full-Stack Engineer Web / Mobile App

📍 DSA | Java | Problem Solving

---

---

# 📘 Dynamic Programming in Java

### _From Recursion to Optimization (Memoization & Tabulation)_

---

## 📑 Table of Contents

1. Introduction to Dynamic Programming
2. Key Concepts
3. Problem 1: Climbing Stairs
   - Recursion
   - Memoization
   - Tabulation

4. Problem 2: Fibonacci Numbers
   - Memoization
   - Tabulation

5. Complexity Analysis
6. Key Takeaways
7. How to Run

---

# 🧠 1. Introduction to Dynamic Programming

Dynamic Programming (DP) is an optimization technique used to solve problems with:

- **Overlapping Subproblems**
- **Optimal Substructure**

Instead of recomputing results, DP stores intermediate results to improve efficiency.

---

# 🔑 2. Key Concepts

| Concept     | Description                               |
| ----------- | ----------------------------------------- |
| Recursion   | Solve problem using function calls        |
| Memoization | Top-down DP (store results in cache)      |
| Tabulation  | Bottom-up DP (build solution iteratively) |

---

# 🧗 3. Problem 1: Climbing Stairs

## 📌 Problem Statement

Given `n` stairs, you can climb:

- 1 step OR
- 2 steps at a time

👉 Find total number of distinct ways to reach the top.

---

## 🔁 Approach 1: Recursion

### 💡 Idea

Break the problem into smaller subproblems:

```
ways(n) = ways(n-1) + ways(n-2)
```

---

### 🧾 Pseudocode

```
function countWays(n):
    if n == 0:
        return 1
    if n < 0:
        return 0
    return countWays(n-1) + countWays(n-2)
```

---

### 💻 Code

```java
// From ClimbingStairs_Recursion.java
public static int countWays(int n) {
    if (n == 0) return 1;
    if (n < 1) return 0;

    return countWays(n - 1) + countWays(n - 2);
}
```

📄 Reference:

---

### ⏱ Complexity

- Time: **O(2ⁿ)** ❌ (Inefficient)
- Space: **O(n)**

---

## ⚡ Approach 2: Memoization (Top-Down DP)

### 💡 Idea

Store computed results to avoid recomputation.

---

### 🧾 Pseudocode

```
function countWays(n, dp):
    if n == 0: return 1
    if n < 0: return 0

    if dp[n] already computed:
        return dp[n]

    dp[n] = countWays(n-1) + countWays(n-2)
    return dp[n]
```

---

### 💻 Code

```java
// From ClimbingStairs_Memoization.java
public static int countWays(int n, int ways[]) {
    if (n == 0) return 1;
    if (n < 1) return 0;

    if (ways[n] != -1) return ways[n];

    ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
    return ways[n];
}
```

📄 Reference:

---

### ⏱ Complexity

- Time: **O(n)** ✅
- Space: **O(n)**

---

## 📊 Approach 3: Tabulation (Bottom-Up DP)

### 💡 Idea

Build solution iteratively from base cases.

---

### 🧾 Pseudocode

```
dp[0] = 1

for i from 1 to n:
    if i == 1:
        dp[i] = dp[i-1]
    else:
        dp[i] = dp[i-1] + dp[i-2]

return dp[n]
```

---

### 💻 Code

```java
// From ClimbingStairs_Tabulation.java
public static int countWaysTab(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
        if (i == 1) {
            dp[i] = dp[i - 1];
        } else {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
    return dp[n];
}
```

📄 Reference:

---

### ⏱ Complexity

- Time: **O(n)** ✅
- Space: **O(n)**

---

# 🔢 4. Problem 2: Fibonacci Number

## 📌 Problem Statement

Find the nth Fibonacci number:

```
F(n) = F(n-1) + F(n-2)
```

---

## ⚡ Memoization Approach

### 🧾 Pseudocode

```
function fibonacci(n, dp):
    if n == 0 or 1:
        return n

    if dp[n] exists:
        return dp[n]

    dp[n] = fibonacci(n-1) + fibonacci(n-2)
    return dp[n]
```

---

### 💻 Code

```java
public static int fibonacci(int n, int f[]) {
    if (n == 0 || n == 1) return n;

    if (f[n] != 0) return f[n];

    f[n] = fibonacci(n - 1, f) + fibonacci(n - 2, f);
    return f[n];
}
```

---

## 📊 Tabulation Approach

### 🧾 Pseudocode

```
dp[0] = 0
dp[1] = 1

for i = 2 to n:
    dp[i] = dp[i-1] + dp[i-2]

return dp[n]
```

---

### 💻 Code

```java
public static int fibonacciTabulation(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

📄 Reference:

---

# 📈 5. Complexity Analysis

| Approach    | Time  | Space | Efficiency |
| ----------- | ----- | ----- | ---------- |
| Recursion   | O(2ⁿ) | O(n)  | ❌ Poor    |
| Memoization | O(n)  | O(n)  | ✅ Good    |
| Tabulation  | O(n)  | O(n)  | ✅ Best    |

---

# 🎯 6. Key Takeaways

- Recursion is intuitive but inefficient
- Memoization avoids recomputation
- Tabulation is iterative and often preferred
- Many DP problems reduce to **Fibonacci-like relations**
- Identifying overlapping subproblems is crucial

---

# ▶️ 7. How to Run

### Compile

```bash
javac FileName.java
```

### Run

```bash
java FileName
```

Example:

```bash
javac ClimbingStairs_Tabulation.java
java ClimbingStairs_Tabulation
```

---

# 📌 Bonus: Template for Any DP Problem

```
1. Identify base cases
2. Find recurrence relation
3. Choose approach:
   - Recursion
   - Memoization
   - Tabulation
4. Optimize space if possible
```

---

# 👨‍💻 Author

**Satinder Singh Sall**
Data Structures and Algorithms
Full-Stack Engineer Web / Mobile App
