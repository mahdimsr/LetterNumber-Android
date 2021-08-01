# LetterNumber-Android
Android library for convert number to letter

You can pass number and get the number in letter

## Example
```kotlin
    val number = "123456789000"
    val convertedNumber = LetterNumber(number.toLong()).convertNumberToLetter()
    convertedNumber = "صد و بیست و سه میلیارد و چهارصد و پنجاه و شش میلیون و هفتصد و هشتاد و نه هزار" 
```

## How it works
you pass number to
```kotlin
    LetterNumber("you`re number as Long")
```
then call this function:
```kotlin
    convertNumberToLetter()
```
it returns string value which is your number as letter

## Install
```groovy
    dependencies {
    	        implementation 'com.github.mahdimsr:LetterNumber-Android:version'
    	}
```
last version: 1.0.1