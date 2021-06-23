# Scalpelexample
---
## Code128编码器  
支持将符合规范的字符串编码为Code128图像,输出位图  
目前支持Code128A,Code128B,Code128C; 不支持UCC/EAN-128,如果需要这种编码请直接使用zxing  

* 使用方法  

```java
    Code128Encoder encoder =  new Code128Encoder(new BarcodeEncoderParams());
    String content = "0123456789";
    Bitmap result = encoder.encode(content);
```
通过参数BarcodeEncoderParams指定Code128编码子集和生成的条码样式  


[测试](./docs/md/test)
