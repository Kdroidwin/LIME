package io.github.chipppppppppp.lime.hooks;

import io.github.chipppppppppp.lime.LimeOptions;

public class OutputCommunication implements IHook {
    @Override
    public void hook(LimeOptions limeOptions, XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (!limeOptions.outputCommunication.checked) return;

        XposedBridge.hookAllMethods(
                loadPackageParam.classLoader.loadClass("org.apache.thrift.n"),
                "a",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log(param.args[0].toString() + ": " + param.args[1].toString());
                    }
                }
        );

        XposedBridge.hookAllMethods(
                loadPackageParam.classLoader.loadClass("org.apache.thrift.n"),
                "b",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log(param.args[0].toString() + ": " + param.args[1].toString());
                    }
                }
        );
    }
}