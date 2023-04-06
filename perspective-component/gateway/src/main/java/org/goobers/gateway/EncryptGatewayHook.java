package org.goobers.gateway;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.tags.model.TagManager;
import com.inductiveautomation.ignition.common.tags.model.TagPath;
import com.inductiveautomation.ignition.common.tags.paths.parser.TagPathParser;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.common.model.values.QualifiedValue;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EncryptGatewayHook extends AbstractGatewayModuleHook {

    private static final LoggerEx log = LoggerEx.newBuilder().build("goobers.gateway.EncryptGatewayHook");

    public EncryptGatewayHook() throws IOException {
        log.info("I am Here");
    }

    @Override
    public void startup(LicenseState licenseState) {
        log.info("I am Here");
    }

    @Override
    public void shutdown() {
        log.info("I am Here");
    }

    // ...


    private GatewayContext gatewayContext;


    @Override
    public void setup(GatewayContext context) {

        try{
            // Parse the tag path string
            TagPath tagPath = TagPathParser.parse("[default]dashboardView");


            List<TagPath> tagPaths = new ArrayList<>();
            tagPaths.add(tagPath);

            // Get the TagManager instance
            TagManager tagManager = gatewayContext.getTagManager();

            // Read the tag value
            // Read the tag value asynchronously
            CompletableFuture<List<QualifiedValue>> futureValue = tagManager.readAsync(tagPaths);

            System.out.println(futureValue);
            System.out.println(futureValue);
        }
        catch (Exception e){

        }

    }



}
