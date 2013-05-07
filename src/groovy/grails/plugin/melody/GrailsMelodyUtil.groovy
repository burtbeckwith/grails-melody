package grails.plugin.melody

import grails.util.GrailsUtil
import grails.util.Holders

class GrailsMelodyUtil {
    static ConfigObject getGrailsMelodyConfig() {
		def config = Holders.grailsApplication.config
		GroovyClassLoader classLoader = new GroovyClassLoader(GrailsMelodyUtil.getClassLoader())
		try {
			config.merge(new ConfigSlurper(GrailsUtil.environment).parse(classLoader.loadClass('GrailsMelodyConfig')))
		} catch (Exception e) {
			// ignored, use defaults
		}
		return config
	}
}
