#include <string.h>
#include <jni.h>

/**
 * Unit transformation function from Celsius to fahrenheit,
 * written in c. Usage: called by using JNI
 */

/** For adapter MyListAdapter. */
jint
Java_challenge_qualcomm_guoxiao_thermo_MyListAdapter_jniTranform( JNIEnv* env,
                                                  jobject thiz,
                                                    jint input)
{
    int temp = input;
    return (jint) (temp * 9 / 5 + 32);
}

/** For class MainActivity. */
jint
Java_challenge_qualcomm_guoxiao_thermo_MainActivity_jniTranform( JNIEnv* env,
                                                                  jobject thiz,
                                                                  jint input)
{
    int temp = input;
    return (jint) (temp * 9 / 5 + 32);
}
