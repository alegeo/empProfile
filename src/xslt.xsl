<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" />
    <xsl:template match="/" > 
            <profile>
                <cv_info>
                <name><xsl:apply-templates select="/cv/name" /> </name>
                <address><xsl:apply-templates select="/cv/address" /> </address>
                <telephone><xsl:value-of select="/cv/telephone" /> </telephone>
                <email><xsl:value-of select="/cv/email" /></email>
                <!-- <education/> -->
                <xsl:for-each select="/cv/language"> 
                        <language> <xsl:value-of select="." /></language>
                </xsl:for-each>
                <qualifications><xsl:value-of select="/cv/qualifications" /></qualifications>
                <jobType><xsl:value-of select="/cv/jobType" /></jobType>
                <desiredPosition><xsl:value-of select="/cv/desiredPosition" /></desiredPosition>
                <references><xsl:value-of select="/cv/references" /> </references>
                <motivation><xsl:value-of select="/cv/motivation" /> </motivation>
                </cv_info>
                <xsl:for-each select="/empRecord"/>
                <empRecord>  
                    <company><xsl:value-of select="./company"/></company>
                    <contact><xsl:value-of select="./contact"/></contact>
                    <year><xsl:value-of select="./year"/></year>
                    <duration><xsl:value-of select="./duration"/></duration>
                    <position><xsl:value-of select="./position"/></position>
                </empRecord>
                </xsl:for-each>
                    
                    
                </empRecord>
                
                 
                 
        </profile>
    </xsl:template>
        	
</xsl:stylesheet>	