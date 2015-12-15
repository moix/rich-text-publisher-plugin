package org.korosoft.jenkins.plugin.rtp.workflow;

import javax.inject.Inject;

import org.jenkinsci.plugins.workflow.steps.AbstractSynchronousStepExecution;
import org.jenkinsci.plugins.workflow.steps.StepContextParameter;
import org.korosoft.jenkins.plugin.rtp.RichTextPublisher;

import hudson.AbortException;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.Run;
import hudson.model.TaskListener;

public class RichTextPublisherExecution extends AbstractSynchronousStepExecution<Void> {

	@StepContextParameter
    private transient TaskListener listener;

    @StepContextParameter
    private transient FilePath ws;

    @StepContextParameter
    private transient Run build;

    @StepContextParameter
    private transient Launcher launcher;
    
    @Inject
    private transient RichTextPublisherStep step;
    
	@Override
	protected Void run() throws Exception {
		final String text = step.getText();
		if (text == null) {
			throw new AbortException("Cannot publish the text. Text is not specified.");
		}
		
		boolean res = RichTextPublisher.publishRichText(build, ws, launcher, listener, text, RichTextPublisher.class);
		if (!res) {
            throw new AbortException("Cannot publish rich text");
        }  
		return null;
	}

}
