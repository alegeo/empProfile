<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" indent="yes"/>
<profile> 
	<xsl:template match="/cv">
		<name><xsl:value-of select="name"/></name>
		<telephone><xsl:value-of select="telephone"/></telephone>
		<email><xsl:value-of select="email"/></email>
		<desiredPosition>YET DONE.</desiredPosition>
		<xsl:for-each select="language"> 
			<language><xsl:value-of select="." /></language>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="/transcript">
	<!-- <xsl:for-each name="the variable come from above"> -->
	<education>
		<university><xsl:value-of select="university">
		<program><xsl:value-of select="program">
		<!-- <gpa>complicated programming will be here </gpa> -->
	</education>
	<xsl:template match="/cv">
		<motivation><xsl:value-of="motivation"/></motivation>
		<!-- <place_desired><xsd:value-of="place_desired"/></motivation> -->
		<jobType><xsl:value-of="jobType"/></jobType>
		<qualifications><xsl:value-of="qualifications"/></qualifications>
        <references><xsl:value-of="references"/></references>
	</xsl:template>
	<empRecord>
	<xsl:template match="/empRecord.xsd">
		<xsl:for-each select="./company">
		<company>
		<!-- not ready at all -->
			<name><xsl:value-of="company"/></name>
			<category></category>
			<contact><xsl:value-of="/company_info"/></contact>
		</company>
		<year><xsl:value-of="./year"/></year>
		<duration><xsl:value-of="./duration"/></duartion>
		<position><xsl:value-of="./positon"/></position>
		</xsl:for-each>
	</xsl:template>

	</empRecord>
</profile>	
</xsl:stylesheet>	