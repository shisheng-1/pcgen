/*
 * Copyright 2007, 2008 (C) Tom Parker <thpr@users.sourceforge.net>
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.cdom.list;

import java.util.StringTokenizer;

import pcgen.cdom.base.CDOMListObject;
import pcgen.cdom.enumeration.ListKey;
import pcgen.cdom.enumeration.Type;
import pcgen.core.spell.Spell;

/**
 * ClassSpellList is a CDOMListObject designed to reference a List of Spell
 * objects.
 * 
 * A ClassSpellList is effectively a specialized SpellList that represents Spell
 * objects associated with a particular PCClass.
 */
public class ClassSpellList extends CDOMListObject<Spell>
{

	/**
	 * Returns the Spell Class object (Spell.class)
	 * 
	 * @return the Spell Class object (Spell.class)
	 */
	public Class<Spell> getListClass()
	{
		return Spell.class;
	}

	@Override
	public boolean isType(String type)
	{
		if (type.length() == 0)
		{
			return false;
		}

		//
		// Must match all listed types in order to qualify
		//
		StringTokenizer tok = new StringTokenizer(type, ".");
		while (tok.hasMoreTokens())
		{
			if (!containsInList(ListKey.TYPE, Type.getConstant(tok.nextToken())))
			{
				return false;
			}
		}
		return true;
	}


	// No additional Functionality :)

}
