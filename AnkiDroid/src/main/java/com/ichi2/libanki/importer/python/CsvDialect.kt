/*
 Copyright (c) 2020 David Allison <davidallisongithub@gmail.com>

 This program is free software; you can redistribute it and/or modify it under
 the terms of the GNU General Public License as published by the Free Software
 Foundation; either version 3 of the License, or (at your option) any later
 version.

 This program is distributed in the hope that it will be useful, but WITHOUT ANY
 WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 PARTICULAR PURPOSE. See the GNU General Public License for more details.

 You should have received a copy of the GNU General Public License along with
 this program.  If not, see <http://www.gnu.org/licenses/>.

 This file incorporates work covered by the following copyright and permission notice.
 Please see the file LICENSE in this directory for full details

 Ported from https://github.com/python/cpython/blob/c88239f864a27f673c0f0a9e62d2488563f9d081/Modules/_csv.c

 */

package com.ichi2.libanki.importer.python

class CsvDialect(@Suppress("unused") private val name: String) {
    /** Controls when quotes should be generated by the writer and recognised by the reader. It can take on any of the [QUOTE_*][Quoting] constants (see section Module Contents) and defaults to [Quoting.QUOTE_MINIMAL].  */
    @JvmField
    val mQuoting = Quoting.QUOTE_MINIMAL

    /**  Controls how instances of [mQuotechar] appearing inside a field should themselves be quoted. When True, the character is doubled. When False, the [mEscapechar] is used as a prefix to the [mQuotechar].
     * On output, if [mDoublequote] is False and no [mEscapechar] is set, Error is raised if a [mQuotechar] is found in a field.  */
    @JvmField
    var mDoublequote = true

    /** A one-character string used to separate fields. It defaults to ','.  */
    @JvmField
    var mDelimiter = ','

    /** When True, whitespace immediately following the delimiter is ignored. The default is False.  */
    @JvmField
    var mSkipInitialSpace = false

    /** The string used to terminate lines produced by the writer. It defaults to '\r\n'.
     * Note The reader is hard-coded to recognise either '\r' or '\n' as end-of-line, and ignores [mLineTerminator]. This behavior may change in the future.
     */
    @JvmField
    val mLineTerminator = "\r\n"

    /** A one-character string used to quote fields containing special characters, such as the delimiter or [mQuotechar], or which contain new-line characters. It defaults to '"'.  */
    @JvmField
    var mQuotechar = '"'

    /** When True, raise exception Error on bad CSV input. The default is False.  */
    @JvmField
    val mStrict = false

    /** A one-character string used by the writer to escape the delimiter if quoting is set to [Quoting.QUOTE_NONE] and the [mQuotechar] if [mDoublequote] is False. On reading, the [mEscapechar] removes any special meaning from the following character. It defaults to None, which disables escaping.  */
    @JvmField
    val mEscapechar = '\u0000'

    enum class Quoting {
        QUOTE_MINIMAL, QUOTE_NONE, QUOTE_NONNUMERIC
    }
}
