# Scalpelexample
---  
edit on 2021/06/24  
lib version v1.0.0

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
可供设置参数:  

参数|描述
:-|:-
setBarcodeFormat(BarcodeFormat)|设置编码方式
setBarcodeHeight(int)|条码高度,不包含间距或者文本的尺寸
setBarcodeUnitWidth(int)|条码单位宽度,正值有效.这个设置和setBarcodeTotalWidth(int)互斥,最后一次设置有效
setBarcodeTotalWidth(int)|条码的总宽度,正值有效.不一定会使用该值.如果计算条空单位尺寸小于1px,那么使用1px条宽单位尺寸如果按照最大值分配了条空的总尺寸,还有剩余,会舍弃这部分值;这个设置和setBarcodeUnitWidth(int)互斥,最后一次设置有效
setSpaceLeft(int)|内容区域左边距
setSpaceTop(int)|内容区域顶边距
setSpaceRight(int)|内容区域右边距
setSpaceBottom(int)|内容区域底边距
setBackgroundColorArgb(int)|设置背景argb颜色
setBarcodeBandColorArgb(int)|设置条码的条argb颜色
setBarcodeSpaceColorArgb(int)|设置条码的空argb颜色
setContentTextColorArgb(int)|设置文本颜色
setShowContent(boolean)|是否在条码底部显示内容文本(是的,如果要显示内容文本,只能显示在底部,这个没得选)
setBarcodeAndContentSpace(int)|设置内容文本和条码之间的间距
setContentTextSizePx(int)|设置内容文本的大小

---

[查看测试报告](./docs/md/test.md)

---  
有bug请提issues,bug修复作为第一优先级处理  
如果需要新增功能或者需要编码其他格式的条码也请提issuse,合理需求作为第二优先级处理