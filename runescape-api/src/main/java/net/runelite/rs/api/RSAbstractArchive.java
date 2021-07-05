package net.runelite.rs.api;

import net.runelite.api.IndexDataBase;
import net.runelite.mapping.Import;

public interface RSAbstractArchive extends IndexDataBase
{
	@Import("takeFile")
	@Override
	byte[] getConfigData(int archiveId, int fileId);

	@Import("getGroupFileIds")
	@Override
	int[] getFileIds(int groupId);

	@Import("groupCount")
	@Override
	int getGroupCount$api();

	@Import("fileIds")
	@Override
	int[][] getFileIds();

	@Import("getFile")
	@Override
	byte[] getFile$api(int groupId, int fileId);

	@Import("getGroupFileCount")
	@Override
	int getGroupFileCount$api(int groupId);

	@Import("fileCounts")
	@Override
	int[] getFileCounts();
}