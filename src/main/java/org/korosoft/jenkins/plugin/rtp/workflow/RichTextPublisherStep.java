package org.korosoft.jenkins.plugin.rtp.workflow;

import javax.annotation.CheckForNull;

import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;

public class RichTextPublisherStep extends AbstractStepImpl {
	
	private final String text;
	
	@DataBoundConstructor
	public RichTextPublisherStep(@CheckForNull String text) {
		this.text = text;
	}
	
	@CheckForNull
	public String getText() {
		return text;
	}
	
	@Extension
	public static class DescriptorImpl extends AbstractStepDescriptorImpl {
		
		public DescriptorImpl() {
			super(RichTextPublisherExecution.class);
		}
		
		@Override
		public String getFunctionName() {
			return "publishRichText";
		}
		
		@Override
		public String getDisplayName() {
			return "Publish Rich text";
		}
	}

}
