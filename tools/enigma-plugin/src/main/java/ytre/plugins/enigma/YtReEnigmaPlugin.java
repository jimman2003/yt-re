package ytre.plugins.enigma;

import cuchaz.enigma.api.EnigmaPlugin;
import cuchaz.enigma.api.EnigmaPluginContext;
import cuchaz.enigma.api.service.JarIndexerService;
import cuchaz.enigma.api.service.NameProposalService;

import ytre.plugins.enigma.tostring.ToStringIndex;
import ytre.plugins.enigma.tostring.ToStringProposer;

public class YtReEnigmaPlugin implements EnigmaPlugin {
	public static final String SERVICE_ID_PREFIX = "ytre:";
	public static final String TO_STRING_INDEX_ID = "to_string_index";
	public static final String TO_STRING_PROPOSER_ID = "to_string_proposer";

	@Override
	public void init(EnigmaPluginContext ctx) {
		var toStringIndex = new ToStringIndex();
		ctx.registerService(SERVICE_ID_PREFIX + TO_STRING_INDEX_ID, JarIndexerService.TYPE, ctx1 -> toStringIndex);
		ctx.registerService(SERVICE_ID_PREFIX + TO_STRING_PROPOSER_ID, NameProposalService.TYPE, ctx1 -> new ToStringProposer(toStringIndex));
	}
}
