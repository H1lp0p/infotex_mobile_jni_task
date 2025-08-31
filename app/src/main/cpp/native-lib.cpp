#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_infotex_1jni_1task_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_infotex_1jni_1task_MainActivity_Mult(JNIEnv *env, jobject thiz, jdouble a,
                                                      jdouble b) {
    return a * b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_infotex_1jni_1task_MainActivity_Div(JNIEnv *env, jobject thiz, jdouble a,
                                                     jdouble b) {
    if (b==0.0){
        jclass exception = env->FindClass("java/lang/ArithmeticException");
        if (exception != nullptr){
            env->ThrowNew(exception, "Dividing by zero");
        }
        return 0;
    }
    return a / b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_infotex_1jni_1task_MainActivity_Sub(JNIEnv *env, jobject thiz, jdouble a,
                                                     jdouble b) {
    return a - b;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_infotex_1jni_1task_MainActivity_Sum(JNIEnv *env, jobject thiz, jdouble a,
                                                     jdouble b) {
    return a + b;
}