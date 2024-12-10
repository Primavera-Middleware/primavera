package br.ufrn.imd.primavera.extension.invocationInterceptor.beforeInterceptor;

import br.ufrn.imd.primavera.extension.invocationInterceptor.annotations.InvocationInterceptorClass;
import br.ufrn.imd.primavera.extension.invocationInterceptor.enums.InvocationType;
import br.ufrn.imd.primavera.extension.invocationInterceptor.InvocationInterceptor;

import java.util.HashMap;
import java.util.Map;

@InvocationInterceptorClass(InvocationType.BEFORE_INVOCATION)
public class ContextInterceptor implements InvocationInterceptor {

    @Override
    public void execute(String context) {
        Map<String, String> contextMap = new HashMap<>();
        String[] contextArray = context.split(";");

        for (String contextElement : contextArray) {
            String[] contextElementArray = contextElement.split(":");
            contextMap.put(contextElementArray[0], contextElementArray[1]);
        }
        if (contextMap.containsKey("SessionID")) {
            System.out.println("SessionID: " + contextMap.get("SessionID"));
        }
    }

}
