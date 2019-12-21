#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring
JNICALL
net_example_com_cleansample_core_di_NetworkModule_getAPIKey(JNIEnv *env, jobject /* this */) {
    std::string api_key = "http://api.acme.international/";
    return env->NewStringUTF(api_key.c_str());
}
